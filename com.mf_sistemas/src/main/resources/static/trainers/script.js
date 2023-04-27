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
async function deleteTrainer(trainerId) {
    try {
        const response = await fetch(`/Trainers/${trainerId}`, {
            method: 'DELETE',
        });
        if(response.ok) {
            console.log(`Trainer with ID ${trainerId} deleted`);
            fetchTrainers();
        } else {
            console.error(`Failed to delete the Trainer with ID ${trainerId}`, error);
        }
    } catch (error) {
        console.error(`Failed to delete the Trainer with ID ${trainerId}`, error);
    }
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

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.className = 'delete-btn';
        deleteButton.onclick = () => deleteTrainer(trainer.trainerId);

        const deleteCell = document.createElement('td');
        deleteCell.appendChild(deleteButton);
        row.appendChild(deleteCell);

        trainerTableBody.appendChild(row);
    })
}
function toggleMenu() {
    const sidebar = document.getElementById('sidebar');
    const toggleMenuButton = document.getElementById('toggle-menu');

    if (sidebar.style.left === '-200px' || sidebar.style.left === '') {
        sidebar.style.left = '0px';
        toggleMenuButton.innerHTML = '←';
    } else {
        sidebar.style.left = '-200px';
        toggleMenuButton.innerHTML = '→';
    }
}
