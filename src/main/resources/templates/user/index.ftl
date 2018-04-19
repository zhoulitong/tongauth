<html>
    <#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
<#--一边栏sidebar-->
        <#include "../common/nav.ftl">
<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <form role="form" method="post" action="/seller/category/save">
                    <div class="form-group">
                        <label>名字</label>
                        <input name="categoryName" type="text" class="form-control"
                               value="${(prodcutCategory.categoryName)!''}"/>
                    </div>
                    <div class="form-group">
                        <label>type</label>
                        <input name="categoryType" type="number" class="form-control"
                               value="${(prodcutCategory.categoryType)!''}"/>
                    </div>

                    <input hidden type="text" name="categoryId" value="${(prodcutCategory.categoryId) ! ''}">
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
