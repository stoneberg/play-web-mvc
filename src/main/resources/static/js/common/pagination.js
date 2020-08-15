/****************************************************************************************************
*    @IPCCP (IPC Container Platform) version 1.0                                                    
*    @Description: Pagination Module                                                               
*    @Class: pagination.js                                                                          
*    @Author: 이유평                                                                                
*    @Since: 2019.01.27                                                                             
*****************************************************************************************************/
(function($, thisPage) {
    
    /** page result size(default : 10)  **/
    var PAGE_SIZE = thisPage.pageSize || 10;
    
    /** page range block(default : 10) **/
    var PAGE_BLOCK = thisPage.pageBlock || 10;
    
    /** template table list && pagination **/
    $.fn.template = function(result, callback, pageNo, orderNo) {
        var page = pageNo || 1;
        var order = orderNo || 0;
        
        // template table list
        var currentResult = getOffsetList(result, page);
        var listHtml = callback(currentResult);
        this.html(listHtml);
        
        // template pagination
        var pagingHtml = getPagination(result.length, page, order);
        var $table = $(this).closest('table');
        $table.next('div').remove();
        
        if (result.length) {
            $table.after(pagingHtml);
            $table.next().show();
        }
        
        return this; 
    };
    
    
    /**
     * return offset page list among total page list
     */
    var getOffsetList = function(resultArr, pageNo) {
        -- pageNo;
        return resultArr.slice(pageNo * PAGE_SIZE, (pageNo + 1) * PAGE_SIZE);
    };
    
    
    /** processing pagination **/
    var getPagination = function(totalRow, pageNo, orderNo) {
        
        var page = pageNo || 1;
        var order = orderNo || 0;
        var totalPage = Math.ceil(totalRow / PAGE_SIZE);
        var pageGroup = Math.ceil(page / PAGE_BLOCK);
        var next = pageGroup * PAGE_BLOCK;
        var prev = next - (PAGE_BLOCK - 1);
        var goNext = 0;
        var goPrev = 0;
        var pagingHtml = '';
        
        if (prev - 1 <= 0) {
            goPrev = 1;
            prev = 1;
        } else {
           goPrev = prev - 1;
        }
        
        if (next > totalPage) {
            goNext = totalPage;
            next = totalPage;
        } else {
            goNext = next + 1;
        }
        
        if (goNext > totalPage) {
            goNext = totalPage;
        }
        
        if (totalRow > 0) {
            
            pagingHtml += '<div class="paging_box">';
            pagingHtml += '<ul class="paging">';
            
            /** |<<| <| **/
            if (page == 1) {
                pagingHtml += '<li><a href="javascript:;" class="ppv dis" data-page="1">맨앞</a></li>';
                pagingHtml += '<li><a href="javascript:;" class="pv dis" data-page="' + goPrev + '">앞</a></li>';
            } else {
                pagingHtml += '<li><a href="javascript:;" class="ppv" data-page="1" onclick=module.pageMove(1,' + order + ');return false;">맨앞</a></li>';
                pagingHtml += '<li><a href="javascript:;" class="pv" data-page="' + goPrev + '" onclick="module.pageMove(' + goPrev + ', ' + order + ');return false;">앞</a></li>';
            }
            
            /** |1|2|3|........|9|10| **/
            for (var pageIndex = prev; pageIndex <= next; pageIndex ++) {
                if (pageIndex == page) {
                    pagingHtml += '<li class="on"><a href="javascript:;">' + pageIndex + '</a></li>';
                } else {
                    pagingHtml += '<li><a href="javascript:;" onclick="module.pageMove(' + pageIndex + ', ' + order + ');return false;" data-page="' + pageIndex + '">' + pageIndex + '</a></li>';
                }
            } 
            
            /** |> |>>| **/
            if (page == totalPage) {
                pagingHtml += '<li><a href="javascript:;" class="nv dis" data-page="' + goNext + '">뒤></li>';
                pagingHtml += '<li><a href="javascript:;" class="nnv dis" data-page="' + totalPage + '">맨뒤</a></li>';
            } else {
                pagingHtml += '<li><a href="javascript:;" class="nv" data-page="' + goNext + '" onclick="module.pageMove(' + goNext + ', ' + order + ');return false;">뒤</a></li>';
                pagingHtml += '<li><a href="javascript:;" class="nnv" data-page="' + totalPage + '" onclick="module.pageMove(' + totalPage + ', ' + order + ');return false;">맨뒤</a></li>';
            }
            
            pagingHtml += '</ul>';
            pagingHtml += '</div>';
            
        }
        
        return pagingHtml;
        
    };
    
    
})(jQuery, thisPage);