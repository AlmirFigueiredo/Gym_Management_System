document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const trainerId = urlParams.get('trainerId');

    if (trainerId) {
        fetchTrainerDetails(trainerId);
    } else {
        window.location.href = '../index.html';
    }
    const deleteButton = document.getElementById('deleteButton');
    deleteButton.addEventListener('click', function () {
        deleteTrainer(trainerId);
    });
    const editButton = document.getElementById('editButton');
    editButton.addEventListener('click', function () {
        window.location.href = `../edit_trainer/edit_trainer.html?trainerId=${trainerId}`;
    });
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
function deleteTrainer(trainerId) {
    const confirmation = confirm("Do you want to delete this trainer?");
    if(confirmation) {
        fetch(`/Trainers/${trainerId}`, {
            method: 'DELETE'
        })
            .then(response => {
                if(response.ok) {
                    alert('Trainer deleted successfully');
                    window.location.href = '../index.html';
                } else {
                    alert('Error deleting trainer:');
                }
            })
            .catch(error => {
                console.error('Error deleting trainer:', error);
            });
    }   
}