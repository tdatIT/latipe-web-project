const handle_change = document.getElementById('handleClick')

if (handle_change) {
    handle_change.addEventListener('click', e => {
        if (e.target.classList.contains("inc") || e.target.classList.contains("dec")) {
            const el = e.target.parentElement.children[1];

            const id = el.id.split("-")[1];
            const btn = document.getElementById(`checkout-${id}`)
            document.getElementById(`calc-money-${id}`).textContent = parseInt(el.value) * parseInt(document.getElementById(`price-${id}`).textContent)
            if (parseInt(document.getElementById(`amount-${id}`).textContent) < parseInt(el.value)) {
                btn.classList.add("disabled")
            } else {
                btn.classList.remove("disabled")
            }
        }
    })
}


function handleCalc(e) {
    console.log(1)
    const id = e.target.id.split("-")[1];
    const btn = document.getElementById(`checkout-${id}`)
    document.getElementById(`calc-money-${id}`).textContent = parseInt(e.target.value) * parseInt(document.getElementById(`price-${id}`).textContent)
    if (parseInt(document.getElementById(`amount-${id}`).textContent) < parseInt(e.target.value)) {
        btn.classList.add("disabled")
    } else {
        btn.classList.remove("disabled")
    }
}