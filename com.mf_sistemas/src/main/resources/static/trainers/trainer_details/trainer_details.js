document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const trainerId = urlParams.get('trainerId');

    if (trainerId) {
        fetchTrainerDetails(trainerId);
    } else {
        window.location.href = '../index.html';
    }
    
});

function fetchTrainerDetails(trainerId) {
    fetch(`/Trainers/${trainerId}`)
        .then(response => response.json())
        .then(trainer => {
            displayTrainerDetails(trainer);
        })
        .catch(error => {
            console.error('Error fetching trainer details:', error);
        });
}

function displayTrainerDetails(trainer) {
    document.querySelector('#trainerId').textContent = trainer.trainerId;
    document.querySelector('#fullName').textContent = trainer.fullName;
    document.querySelector('#salary').textContent = trainer.salary; // Fixed
    document.querySelector('#certificationNumber').textContent = trainer.certificationNumber; // Fixed
    document.querySelector('#email').textContent = trainer.email;
    document.querySelector('#address').textContent = trainer.address;
    document.querySelector('#phoneNumber').textContent = trainer.phoneNumber;
    document.querySelector('#speciality').textContent = trainer.speciality;
}
