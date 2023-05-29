document.getElementById('editTrainerForm').addEventListener('submit', submitForm);

async function fetchTrainerDetails(trainerId) {
    try {
        const response = await fetch(`/Trainers/${trainerId}`);
        const trainer = await response.json();
        displayTrainerDetais(trainer);
    } catch(error) {
        console.error('Error fetching trainer details', error)
    }
}