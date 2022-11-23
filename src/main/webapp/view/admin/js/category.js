const btn = document.getElementById('action-click');
const search = document.getElementById('btn-search');
document.querySelector('.pic-add').addEventListener('change', (e) => {
    if (e.target.files[0]) {
        document
            .querySelector('.pic-review')
            .setAttribute('src', window.URL.createObjectURL(e.target.files[0]));
    }
});

if (btn) {
    btn.addEventListener('click', (e) => {

        if (e.target.classList.contains('btn-edit')) {
            const id =
                e.target.parentElement.parentElement.parentElement.parentElement.childNodes[1].textContent;
            document
                .getElementById('id-category').value = id;
            document
                .getElementById('edit-pic-review')
                .setAttribute('src', document.getElementById(`image-${id}`).getAttribute('src'));
            document.getElementById('name-category').value = document.getElementById(`name-${id}`).textContent;
        } else if (e.target.classList.contains('btn-delete')) {

            // thuc hien lenh xoa
        }
    });
}
document.querySelector('.pic-edit').addEventListener('change', (e) => {
    console.log(e.target.files[0]);
    if (e.target.files[0]) {
        document
            .getElementById('edit-pic-review')
            .setAttribute('src', window.URL.createObjectURL(e.target.files[0]));
    }
});

if (search) {
    search.addEventListener('click', (e) => {
        const status_filter = document.getElementById("FilterTransaction");
        let status ;
        switch (status_filter.options[status_filter.selectedIndex].text){
            case "All":{
                status = "";
                break;
            }
            case "Active":{
                status = "&option=1"
                break;
            }default: {
                status = "&option=2"
                break;
            }
        }
        window.location.href =`category?search=${document.getElementById("search_box").value}${status}`;
    });
}