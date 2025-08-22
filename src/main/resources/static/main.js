// Payment form logic separated from HTML

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('payment-form');
    const dealerIdInput = document.getElementById('dealerid');
    const amountInput = document.getElementById('amount');
    const methodInput = document.getElementById('method');
    const messageArea = document.getElementById('message-area');
    const outputContainer = document.getElementById('output-container');
    const responseCode = document.getElementById('response-code');

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const dealerid = dealerIdInput.value;
        const amount = parseFloat(amountInput.value);
        const method = methodInput.value;

        const postData = {
            dealer_id: dealerid,
            amount: amount,
            paymentMethodType: method
        };

        messageArea.textContent = '';
        messageArea.className = 'mt-8 text-center text-base font-medium';

        messageArea.textContent = 'Initiating payment...';

        try {
            const response = await fetch('http://localhost:8080/api/payments/initiate', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(postData)
            });

            if (!response.ok) {
                const rawBody = await response.text();
                let errorMsg;
                try {
                    errorMsg = JSON.parse(rawBody).message || rawBody;
                } catch {
                    errorMsg = rawBody;
                }
                throw new Error(errorMsg || `HTTP Error! Status:  ${response.status}`);
            }

            const data = await response.json();
            responseCode.textContent = JSON.stringify(data, null, 2);
            outputContainer.classList.remove('hidden');
            messageArea.textContent = 'Payment initiated successfully.';
            messageArea.classList.add('message-success');
        } catch (error) {
            console.error('Fetch error:', error);
            messageArea.textContent = `Error:  ${error.message}`;
            messageArea.classList.add('message-error');
            outputContainer.classList.add('hidden');
        }
    });
});