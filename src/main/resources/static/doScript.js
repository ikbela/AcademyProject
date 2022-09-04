let decode=document.querySelector('#decode');
let encode=document.querySelector('#encode');
let output=document.querySelector('textarea');




    decode.addEventListener('click',()=>{
        output.value= atob(output.value);

    });

    encode.addEventListener('click',()=>{
        output.value= btoa(output.value);

    });

