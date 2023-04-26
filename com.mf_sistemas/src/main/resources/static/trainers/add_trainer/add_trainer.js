document.getElementById('addTrainerForm').addEventListener('submit', submitForm);

async function createNewTrainer(trainerinfo) {
    try {
        const response = await fetch('/Trainers', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(trainerinfo),
        });
        if(response.ok) {
            alert('New trainer created succesfully');
        } else {
            alert('Failed to create new trainer');
        }
    } catch (error) {
        console.error('Erro creating new trainer:', error);
    }
}

function submitForm(event) {
    event.preventDefault();

    const fullName = document.getElementById('fullName').value;
    const speciality = document.getElementById('speciality').value;
    const salary = document.getElementById('salary').value;
    const certificationNumber = document.getElementById('certificationNumber').value;
    const email = document.getElementById('email').value;
    const phoneNumber = document.getElementById('phoneNumber').value
    const address = document.getElementById('address').value

    const newTrainer = {
        fullName: fullName, 
        speciality: speciality,
        salary: salary,
        certificationNumber: certificationNumber,
        email: email,
        phoneNumber: phoneNumber,
        address: address
    }
    createNewTrainer(newTrainer);
}