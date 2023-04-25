document.addEventListener('DOMContentLoaded', function () {
    fetchMembers();
});

function fetchMembers() {
    fetch("/Members")
        .then(response => response.json())
        .then(members => {
            displayMembers(members);
        })
        .catch(error => {
            console.error('Error fetching members:', error);
        });
}