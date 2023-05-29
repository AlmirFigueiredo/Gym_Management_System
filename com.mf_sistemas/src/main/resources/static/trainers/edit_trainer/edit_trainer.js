document.getElementById('editTrainerForm').addEventListener('submit', submitForm);

async function fetchTrainerDetails(trainerId) {
    try {
        const response = await fetch(`/Trainers/${trainerId}`);
        const trainer = await response.json();
        displayTrainerDetais(trainer);
    } catch(error) {
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