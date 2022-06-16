var formObj = document.getElementById('login_form');
var errorMessageObj = document.getElementById('error_message');
formObj.onsubmit = function() {
  if (!formObj.ID.value || !formObj.PW.value) {
    errorMessageObj.textContent = '※IDとパスワードを入力してください！';
    return false;
  }
  errorMessageObj.textContent = null;
};