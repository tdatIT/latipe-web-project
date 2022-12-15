const btn = document.getElementById('action-click');
const search = document.getElementById('btn-search');
if (btn) {
    btn.addEventListener('click', (e) => {
        if (e.target.classList.contains('btn-edit')) {
            console.log(e.target.parentElement.parentElement.parentElement.parentElement.childNodes[1].childNodes[1])
            console.log(e.target.parentElement.parentElement.parentElement.parentElement.childNodes[0].childNodes)
            console.log(e.target.parentElement.parentElement.parentElement.parentElement.childNodes[1])
            const id = e.target.parentElement.parentElement.parentElement.parentElement.childNodes[1].childNodes[1].textContent;

            document.getElementById('name-delivery').value = document.getElementById(`name-${id}`).textContent;
            document.getElementById('price-delivery').value = document.getElementById(`price-${id}`).textContent;
            document.getElementById('des-delivery').value = document.getElementById(`des-${id}`).textContent;
            document.getElementById("editNewDeliveryForm").setAttribute('action', `delivery/edit?deliveryId=${id}`)
        } else if (e.target.classList.contains('btn-delete')) {
            const id =
                e.target.parentElement.parentElement.parentElement.parentElement.childNodes[1].childNodes[0]
                    .textContent;
            console.log(id);
            // thuc hien lenh xoa
        }
    });
}
if (search) {
    search.addEventListener('click', (e) => {
        const status_filter = document.getElementById("FilterTransaction");
        let status ;
        switch (status_filter.options[status_filter.selectedIndex].text){
            case "All":{
                status = "";  break;
            }
            case "Active":{
                status = "&option=1"
                break;
            }default: {
                status = "&option=2"
                break;
            }
        }
        window.location.href =`delivery?search=${document.getElementById("search_box").value}${status}`;
    });
}
