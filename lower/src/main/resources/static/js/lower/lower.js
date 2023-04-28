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

});

function save() {

    var form = $('#lowerForm');
    form.submit();

}

function addChild() {

}