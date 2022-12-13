/**
 *  Form Wizard
 */

'use strict';

// rateyo (jquery)
$(function () {
  var readOnlyRating = $('.read-only-ratings');

  // Star rating
  if (readOnlyRating) {
    readOnlyRating.rateYo({
      rtl: isRtl,
      rating: 4,
      starWidth: '20px'
    });
  }
});

(function () {
  // Init custom option check
  window.Helpers.initCustomOptionCheck();

  // Wizard Checkout
  // --------------------------------------------------------------------

  const wizardCheckout = document.querySelector('#wizard-checkout');
  if (typeof wizardCheckout !== undefined && wizardCheckout !== null) {
    // Wizard form
    const wizardCheckoutForm = wizardCheckout.querySelector('#wizard-checkout-form');
    // Wizard steps
    const next = wizardCheckoutForm.querySelectorAll('.btn-next');
    const wizardCheckoutFormStep4 = wizardCheckoutForm.querySelector('#checkout-confirmation');
    // Wizard next prev button
    const wizardCheckoutNext = [].slice.call(wizardCheckoutForm.querySelectorAll('.btn-next'));
    const wizardCheckoutPrev = [].slice.call(wizardCheckoutForm.querySelectorAll('.btn-prev'));

    let validationStepper = new Stepper(wizardCheckout, {
      linear: false
    });
    const FormValidation1 = next.forEach(e => e.addEventListener('click', function () {
      // Jump to the next step when all fields in the current step are valid
      validationStepper.next();
    }))



    // Confirmation
    // const FormValidation4 = wizardCheckoutFormStep4.addEventListener('click', function () {
    //   // Jump to the next step when all fields in the current step are valid
    //   alert('Submitted..!!');
    // });

    wizardCheckoutNext.forEach(item => {
      item.addEventListener('click', event => {
        // When click the Next button, we will validate the current step
        switch (validationStepper._currentIndex) {
          case 0:
            FormValidation1.validate();
            break;

          case 1:
            FormValidation2.validate();
            break;

          case 2:
            FormValidation3.validate();
            break;

          case 3:
            FormValidation4.validate();
            break;

          default:
            break;
        }
      });
    });

    wizardCheckoutPrev.forEach(item => {
      item.addEventListener('click', event => {
        switch (validationStepper._currentIndex) {
          case 3:
            validationStepper.previous();
            break;

          case 2:
            validationStepper.previous();
            break;

          case 1:
            validationStepper.previous();
            break;

          case 0:

          default:
            break;
        }
      });
    });
  }
})();
