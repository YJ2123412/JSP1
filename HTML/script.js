// 작성자 : 이예진

function isValid(){
    let isValid = true;
    var regbirth = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/
    let regexname= /[a-zA-Z가-힣]/

    const name = document.querySelector('input[name="name"]')
    const formId = document.querySelector('input[name="formId"]')
    const formPw1 = document.querySelector('input[name="formPw1"]')
    const formPw2 = document.querySelector('input[name="formPw2"]')
    const formtel = document.querySelector('input[name="formtel"]')
    const birth = document.querySelector('input[name="birth"]')

    if(formId.value ==''){
        alert('아이디를 입력하세요')
        formId.focus();
        isValid= false;
    } else if(formPw1.value.length< 6){
        alert('비밀번호는 6글자 이상 입력해주세요')
        formPw1.focus();
        isValid= false; 
    } else if(formPw1.value!=formPw2.value){
        alert('비밀번호가 일치하지 않습니다.')
        formPw2.focus();
        isValid= false; 
    } else if (name.value == '') {
        alert('이름을 입력하세요')
        name.focus();
        isValid= false;    
    } else if(!regexname.test(name.value)){ 
        alert('이름에 기호나 숫자가 포함되어 있습니다')
        name.focus();
        isValid= false; 
    } else if(birth.value ==''){
        alert('생년월일을 입력해주세요 YYYY-MM-DD')
        birth.focus();
        isValid =false;
    } else if(!regbirth.test(birth.value)){
        alert('생일 입력 양식을 확인해 주세요 YYYY-MM-DD')
        birth.focus();
        isValid =false;
    } else if(formtel.value == ''){
        alert('번호를 입력하세요')
        formtel.focus();
        isValid= false;   
    }
    if(isValid){
        alert(`${formId.value}님 가입을 환영합니다.`)
        window.location.href = 'http://127.0.0.1:5500/day3_form/success.html';
    }
}

document.getElementById('complete').addEventListener('click',isValid)




















