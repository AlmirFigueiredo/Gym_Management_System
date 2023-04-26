function submitForm(event) {
    event.preventDefault();

    const fullName = document.getElementById('fullName').value;
    const memberShipType = document.getElementById('memberShipType').value;
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value
    const email = document.getElementById('email').value;
    const address = document.getElementById('email').value;
    const phoneNumber = document.getElementById('phoneNumber').value;
    
    const newMember = {
        fullName: fullName,
        memberShipType: memberShipType,
        startDate: startDate,
        endDate: endDate,
        email: email,
        address: address,
        phoneNumber: phoneNumber
    }

    
}