const btn = document.getElementById('action-click');
const search = document.getElementById('btn-search');
if (btn) {
    btn.addEventListener('click', (e) => {
        if (e.target.classList.contains('btn-edit')) {
            const id = e.target.parentElement.parentElement.parentElement.parentElement.childNodes[1].childNodes[1].textContent;
            console.log(e.target.parentElement.parentElement.parentElement.parentElement.childNodes[1].childNodes[0])
            console.log(e.target.parentElement.parentElement.parentElement.parentElement.childNodes[1].childNodes[1].v)
            document.getElementById('name-userLevel').value = document.getElementById(`name-${id}`).textContent;
            document.getElementById('point-userLevel').value = document.getElementById(`cost-${id}`).textContent;
            document.getElementById('discount-userLevel').value = document.getElementById(`des-${id}`).textContent;
            document.getElementById("editNewUserLevelForm").setAttribute('action', `userLevel/edit?userLevelId=${id}`)
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
        let status;
        switch (status_filter.options[status_filter.selectedIndex].text) {
            case "All": {
                status = "";
                break;
            }
            case "Active": {
                status = "&option=1"
                break;
            }
            default: {
                status = "&option=2"
                break;
            }
        }
        window.location.href = `userLevel?search=${document.getElementById("search_box").value}${status}`;
    });
}
