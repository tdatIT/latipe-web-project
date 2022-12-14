const sortBy = document.getElementById('sortBy');
const btn_search = document.getElementById('btn-search');
const search = document.getElementById('seach-text');
const maxamount = document.getElementById('maxamount');
const minamount = document.getElementById('minamount');

if (btn_search) {
    btn_search.addEventListener('click', (e) => {
        let filter ="";
        if(sortBy){
            filter+=`&status=${sortBy.value}`
        }
        if(maxamount){
            filter+=`&maxPrice=${maxamount.value}&minPrice=${minamount.value}`
        }
        window.location.href =`product?search=${search.value}${filter}`;
    });
}
