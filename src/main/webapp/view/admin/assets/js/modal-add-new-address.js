/**
 * Add New Address
 */

'use strict';

// Select2 (jquery)
$(function () {
  const select2 = $('.select2');

  // Select2 Country
  if (select2.length) {
    select2.each(function () {
      var $this = $(this);
      $this.wrap('<div class="position-relative"></div>').select2({
        placeholder: 'Select value',
        dropdownParent: $this.parent()
      });
    });
  }
});

// Add New Address form validation
document.addEventListener('DOMContentLoaded', function () {
  (function () {
    // initCustomOptionCheck on modal show to update the custom select
    let addNewAddress = document.getElementById('addNewAddress');
    addNewAddress.addEventListener('show.bs.modal', function (event) {
      // Init custom option check
      window.Helpers.initCustomOptionCheck();
    });


  })();
});
