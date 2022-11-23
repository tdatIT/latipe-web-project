const search = document.getElementById('btn-search');
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
        window.location.href =`product?search=${document.getElementById("search_box").value}${status}`;
    });
}
