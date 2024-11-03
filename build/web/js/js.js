/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function check()
{
    for( i = 0; i <= document.form1.RB.length; i++ ){

        if(document.form1.RB[0].checked==true) {
              document.form1.price.value=5000;
        }
        else if(document.form1.RB[1].checked==true) {
              document.form1.price.value=7000;
        }
        else if(document.form1.RB[2].checked==true) {
             document.form1.price.value=10000;
        }
      else if(document.form1.RB[3].checked==true) {
             document.form1.price.value=14000;
        }
      else if(document.form1.RB[4].checked==true) {
             document.form1.price.value=25000;
        }
       else if(document.form1.RB[5].checked==true) {
             document.form1.price.value=50000;
        }
       else if(document.form1.RB[6].checked==true) {
             document.form1.price.value=100000;
        }
       else if(document.form1.RB[7].checked==true) {
             document.form1.price.value=250000;
        }
       else if(document.form1.RB[8].checked==true) {
             document.form1.price.value=500000;
        }
       else if(document.form1.RB[9].checked==true) {
             document.form1.price.value=1000000;
        }
    
}
}

function sub(){
    var id = document.getElementById("ID").value;
    var telepon = document.getElementById("nomor").value;

    if( id != "" && telepon != ""){
      alert("Pembayaran Anda Berhasil, dimohon untuk Relog akun Anda! dan UC sudah bertambah.");
    }
  }

  function checkNum() 
{
  x = event.charCode;
  if (( x >= 65  && x <=90) || (x >= 97 && x <=122))
  {
      alert("Masukkan Angka.");
      document.form1.telp.value='';
  }
}

