document.addEventListener('DOMContentLoaded', function () {
    fetchTrainers();
})

function fetchTrainers() {
    fetch("/Trainers")
        .then(response => response.json())
        .then(trainers => {
            displayTrainers(trainers);
        })
        .catch(error => {
            console.error('Error fetching trainers: ', error);
        });
}
function displayTrainers(trainers) {
    const trainerTableBody = document.querySelector('#trainerTable tbody');
    trainerTableBody.innerHTML = '';
    trainers.forEach(trainer => {
        const row = document.createElement('tr');

        const trainerIdCell = document.createElement('td');
        trainerIdCell.textContent = trainer.trainerId;
        row.appendChild(trainerIdCell);

        const trainerNameCell = document.createElement('td');
        trainerNameCell.textContent = trainer.fullName;
        row.appendChild(trainerNameCell);

        const trainerSpecialityCell = document.createElement('td');
        trainerSpecialityCell.textContent = trainer.speciality;
        row.appendChild(trainerSpecialityCell);

        const trainerCertificationNumberCell = document.createElement('td');
        trainerCertificationNumberCell.textContent = trainer.certificationNumber;
        row.appendChild(trainerCertificationNumberCell);

        row.classList.add('table-row-button');
        row.addEventListener('click', () => {
            window.location.href = `/trainer_details/trainer_details.html?trainerId=${trainer.trainerId}`;
        });
        trainerTableBody.appendChild(row);
    })
}

