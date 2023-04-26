document.getElementById('addTrainerForm').addEventListener('submit', submitForm);

async function createNewTrainer(trainerinfo) {

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