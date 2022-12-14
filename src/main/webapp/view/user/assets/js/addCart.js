const inc = document.querySelector(".inc");
const dec = document.querySelector(".dec");
const amount = document.querySelector(".val-amount");

const submit = document.getElementById("btn-submit")
if (amount){
    amount.addEventListener("change", (e) => {
        const arr = submit.href.split("&")
        submit.href = arr[0] + `&quantity=${e.target.value}`
    })
}

// if (inc) {
//     inc.addEventListener('click', (e) => {
//         const arr = submit.href.split("=")
//         if (parseInt(arr[1]) <= parseInt(max)) {
//             submit.href = arr[0] + `=${parseInt(arr[1]) + 1}`;
//             amount.textContent = "2"
//             console.log(amount)
//         }
//         else{
//
//         }
//
//     })
// }
// if (dec) {
//     dec.addEventListener('click', (e) => {
//         const arr = submit.href.split("=")
//         if (parseInt(arr[1]) > 0) {
//             submit.href = arr[0] + `=${parseInt(arr[1]) - 1}`;
//             amount.textContent = `${parseInt(arr[1]) + 1}`
//         }
//     })
// }
