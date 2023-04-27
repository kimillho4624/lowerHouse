$(document).ready(function() {

    //하원 종류 라디오 선택 이벤트
    $("input[name='lowerType']").change(function(){
        var lowerType = $("input[name='lowerType']:checked").val();

        //도보일 경우
        if(lowerType == 'B'){
            $("#selectCarNo").val("0").prop("selected", true)
            $('.carChoice').hide();
        }

        //차량일 경우
        if(lowerType == 'A'){
            $('.carChoice').show();
        }

    });

    //하원 시간 시 선택 select option 부여

    var timeArr = [];
    var timeVal = "";

    for( var i=9; i< 24; i++) {

        if(i<10) {
            timeVal = "0"+i;
        } else {
            timeVal = i;
        }

        timeArr[i] = "<option value="+timeVal+">"+timeVal+"</option>"
    }

    $("#selectHh").append(timeArr.join(""));

   //하원 시간 분 선택 select option 부여

   var timeMiArr = [];
   var timeMiVal = "";

   for( var i=0; i< 6; i++) {

       timeMiVal = i+"0";

       timeMiArr[i] = "<option value="+timeMiVal+">"+timeMiVal+"</option>"
   }
   $("#selectMi").append(timeMiArr.join(""));

});

function save() {

    var form = $('#lowerForm');
    form.submit();

}

