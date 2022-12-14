const address = document.getElementById('card-address')
const security = document.getElementById('card-password')
const display_address = document.getElementById('display-address');
const display_sec = document.getElementById('display-sec');
const editAddress = document.getElementById('click-address')
const showAdd = document.getElementById('showAdd');
const editUser = document.getElementById('btn-edituser');

const toggleAddress = document.getElementById('addNewAddressForm')

if (display_address) {
    display_address.addEventListener('click', e => {
        address.style.display = 'block';
        security.style.display = 'none';
        display_address.classList.add('active')
        display_sec.classList.remove('active')
    })
}
if (display_sec) {
    display_sec.addEventListener('click', e => {
        security.style.display = 'block';
        address.style.display = 'none';
        display_sec.classList.add('active')
        display_address.classList.remove('active')
    })
}

if (showAdd) {
    showAdd.addEventListener('click', e => {
        document.querySelector('.address-title').textContent = 'Add New Address';
    })
}

document.querySelector('.pic-edit').addEventListener('change', (e) => {
    if (e.target.files[0]) {
        document
            .getElementById('edit-pic-review')
            .setAttribute('src', window.URL.createObjectURL(e.target.files[0]));
        toggleAddress.action = `userAddress/create`
    }
});

if (editAddress) {
    editAddress.addEventListener('click', (e) => {
        const data = e.target;
        if (data.classList.contains('edit-address')) {
            document.querySelector('.address-title').textContent = 'Edit Address';
            const id = data.id.split('-')[1];
            document.getElementById('address_id').value = id
            document.getElementById('modalAddressName').value = document.getElementById(`address-name-${id}`).textContent
            document.getElementById('modalAddressPhone').value = document.getElementById(`address-phone-${id}`).textContent
            document.getElementById('modalAddressCountry').value = document.getElementById(`address-country-${id}`).textContent
            document.getElementById('modalAddressCity').value = document.getElementById(`address-city-${id}`).textContent
            document.getElementById('modalAddressZipCode').value = document.getElementById(`address-zipcode-${id}`).textContent
            toggleAddress.action = `userAddress/edit?addressId=${id}`
        }
    })
}

if (editUser) {
    editUser.addEventListener('click', (e) => {
        document.getElementById('modalEditUserFirstName').value = document.getElementById(`userFN`).textContent
        document.getElementById('id_card').value = document.getElementById(`userCCCD`).textContent
        document.getElementById('modalEditUserLastName').value = document.getElementById(`userLN`).textContent
        document.getElementById('modalEditUserEmail').value = document.getElementById(`userEmail`).textContent
        document.getElementById('modalEditUserPhone').value = document.getElementById(`userPhone`).textContent
    })
}

