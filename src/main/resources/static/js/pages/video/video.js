const module = (function(global, $, _, moment, thisPage) {

    /***************************************************************************
     * @ 모듈 변수(상수) 선언
     **************************************************************************/
    const CTX = thisPage['ctxPath'];

    /***************************************************************************
     * @ 모듈 함수 선언
     **************************************************************************/
    function getCurTime() {
        const vid = document.getElementById('esign-video');
        window.alert("current play time is " + vid.currentTime);
    }

    function setCurTime() {
        const vid = document.getElementById('esign-video');
        vid.currentTime = 5; // seconds
    }

    /***************************************************************************
     * @ jquery 이벤트 등록
     **************************************************************************/
    function moduleEventHandlers() {

        $('#get').on('click', function (e) {
            e.preventDefault();
            getCurTime();
        });

        $('#set').on('click', function (e) {
            e.preventDefault();
            setCurTime();
        });

    }

    /***************************************************************************
     * @ 화면 로딩 시 최초로 실행할 함수 선언
     **************************************************************************/
    function moduleInitializr() {

    }


    /***************************************************************************
     * @ DOM Ready 실행
     **************************************************************************/
    $(function() {
        moduleEventHandlers();
        moduleInitializr();
    });

    /***************************************************************************
     * @ 외부로 노출할 함수 선언
     **************************************************************************/
    return {
        //pageMove : pageMove, // 페이징 링크 클릭 처리
    };


})(window, jQuery, _, moment, thisPage);