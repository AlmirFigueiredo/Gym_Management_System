document.getElementById('editTrainerForm').addEventListener('submit', submitForm);

async function fetchTrainerDetails(trainerId) {
    try {
        const response = await fetch(`/Trainers/${trainerId}`);
        const trainer = await response.json();
        displayTrainerDetais(trainer);
    } catch (error) {
        console.error('Error fetching trainer details', error);
    }
}

function displayTrainerDetais(trainer) {
    document.getElementById('fullName').value = trainer.fullName;
    document.getElementById('email').value = trainer.email;
    document.getElementById('phoneNumber').value = trainer.phoneNumber;
    document.getElementById('address').value = trainer.address;
    document.getElementById('speciality').value = trainer.speciality;
    document.getElementById('salary').value = trainer.salary;
    document.getElementById('certificationNumber').value = trainer.certificationNumber;
}

async function updateTrainer(trainerInfo) {
    const urlParams = new URLSearchParams(window.location.search);
    const trainerId = urlParams.get('trainerId');
    try {
        const response = await fetch(`/Trainers/${trainerId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(trainerInfo),
        });
        if (response.ok) {
            alert('Trainer updated successfully');
        } else {
            alert('Failed to update trainer');
        }
    } catch (error) {
        console.error('Error updating trainer:', error);
    }
}

function submitForm(event) {
    event.preventDefault();

    const fullName = document.getElementById('fullName').value;
    const email = document.getElementById('email').value;
    const address = document.getElementById('address').value;
    const phoneNumber = document.getElementById('phoneNumber').value;
    const speciality = document.getElementById('speciality').value;
    const salary = document.getElementById('salary').value;
    const certificationNumber = document.getElementById('certificationNumber').value;


    const newTrainer = {
        fullName: fullName,
        email: email,
        address: address,
        phoneNumber: phoneNumber,
        speciality: speciality,
        salary: salary,
        certificationNumber: certificationNumber
    }
    updateTrainer(newTrainer).then(() => {
        window.location.href = '../index.html'
    });
    event.target.reset();
}

document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const trainerId = urlParams.get('trainerId');

    if (trainerId) {
        fetchTrainerDetails(trainerId);
    } else {
        window.location.href = '../index.html';
    }
});