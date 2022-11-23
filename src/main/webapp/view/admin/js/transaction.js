const search = document.getElementById('btn-search');
if (search) {
    search.addEventListener('click', (e) => {
        const status_filter = document.getElementById("FilterTransaction");
        let status;
        switch (status_filter.options[status_filter.selectedIndex].text) {
            case "All": {
                status = "";
                break;
            }
            case "Processing": {
                status = "&status=1"
                break;
            }
            case "Delivery": {
                status = "&status=2"
                break;
            }
            case "Success": {
                status = "&status=3"
                break;
            }
            default: {
                status = "&status=4"
                break;
            }
        }
        window.location.href = `transaction?search=${document.getElementById("search_box").value}${status}`;
    });
}
