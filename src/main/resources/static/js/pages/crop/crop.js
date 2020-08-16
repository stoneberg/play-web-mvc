const module = (function (global, $, _, moment, thisPage) {

    /***************************************************************************
     * @ 모듈 변수(상수) 선언
     **************************************************************************/
    const CTX = thisPage['ctxPath'];

    /***************************************************************************
     * @ 모듈 함수 선언
     **************************************************************************/


    /***************************************************************************
     * @ jquery 이벤트 등록
     **************************************************************************/
    function moduleEventHandlers() {

        // config croppie
        let $cropImage = $('#cropImage').croppie({
            showZoomer: false,
            viewport: {
                width: 200,
                height: 200,
                type: 'square'
            },
            boundary: {
                width: 300,
                height: 300
            }
        });

        // load image on preview modal
        $('#selectImage').on('change', function () {
            const reader = new FileReader();
            reader.onload = function (event) {
                $cropImage.croppie('bind', {
                    url: event.target.result
                });
            }
            reader.readAsDataURL(this.files[0]);
            $('#previewModal').modal('show');
        });

        // upload cropped image
        $('#uploadImage').on('click', function (e) {
            $cropImage.croppie('result', {
                type: 'blob',
                size: 'viewport'
            }).then(function (blob) {
                const formData = new FormData();
                formData.append("file", blob);
                formData.append("userId", "123456789");
                formData.append("filename", $('#selectImage')[0].files[0].name);
                $.ajaxUpload($.reqPost(CTX + "crop/upload")
                    .setData(formData).build()).done(function (response) {
                    console.log("response===>", response);
                    if (response === "OK") {
                        window.alert("지정한 이미지가 저장되었습니다.");
                        $('#previewModal').modal('hide');
                        $('#selectImage').val('');
                        const urlCreator = window.URL || window.webkitURL;
                        const imageUrl = urlCreator.createObjectURL(blob);
                        $("#croppedImage").attr("src", imageUrl);
                        $("#saveImage").show();
                    }
                });
            });
        });

        $('.close-modal').on('click', function (e) {
            e.preventDefault();
            $('#previewModal').modal('hide');
            $('#selectImage').val('');
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
    $(function () {
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