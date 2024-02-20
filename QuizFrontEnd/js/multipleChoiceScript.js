document.addEventListener('DOMContentLoaded', () => {
    displayQuestion(); 
});

const displayQuestion = async () => {
    try {
        const response = await fetch('http://localhost:8080/multipleChoice');
        const data = await response.json();

        if (data.length > 0) {
            const question = data[0];

            document.getElementById('question').textContent = question.question;
            document.getElementById('answer1').textContent = question.answer1;
            document.getElementById('answer2').textContent = question.answer2;
            document.getElementById('answer3').textContent = question.answer3;
            document.getElementById('answer4').textContent = question.answer4;
        } else {
            console.error('No questions available for display');
        }
    } catch (error) {
        console.error('Error:', error);
    }
};

const submitAnswer = () => {
    const selectedAnswer = document.querySelector('input[name="answer"]:checked');

    if (selectedAnswer) {
        const userGuess = selectedAnswer.value;
        checkAnswer(userGuess);
    } else {
        console.error('No answer selected');
    }
};

const checkAnswer = (userGuess) => {
    const resultElement = document.getElementById('result');
    
    if (userGuess === correctAnswer) {
        resultElement.textContent = 'Correct';
        displayQuestion();
    } else {
        resultElement.textContent = 'Incorrect Answer!';
    }
};
