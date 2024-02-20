const loginForm = document.querySelector("#loginForm");
const submitButton = document.querySelector("#submitBtn");

submitButton.addEventListener("click", (e) => loginUser(e));

const loginUser = async (event) => {
    event.preventDefault();

    const username = document.querySelector("#username").value;
    const password = document.querySelector("#password").value;

    const user = {
        username: username,
        password: password
    };

    try {
        const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        });

        if (response.ok) {
            window.location.href = 'multiple-choice.html';
        } else {
            console.error('Incorrect username/password combination');
        }
    } catch (error) {
        console.error('Login failed due to: ', error);
    }
};