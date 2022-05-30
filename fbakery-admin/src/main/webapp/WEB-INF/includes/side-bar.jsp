<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath }/dashboard"> <img src="${pageContext.request.contextPath }/resources/img/logo.png" alt="" width="130px">
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath }/dashboard">
            <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
        </a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">Chức năng</div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo"> <i class="fas fa-archive"></i> <span>Quản lý sản phẩm</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <a class="collapse-item" href="loai-san-pham"> <i class="fas fa-book mr-1"></i> Loại sản phẩm
                </a>
                <a class="collapse-item" href="san-pham"> <i class="fas fa-cookie mr-1"></i> Sản phẩm
                </a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities"> <i class="fas fa-sort-amount-down"></i> <span>Quản lý đơn hàng</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Trạng thái đơn hàng</h6>
                <a class="collapse-item" href="don-hang-cho-xac-nhan"> <i class="fas fa-tasks mr-1"></i> Chờ xác nhận
                </a>
                <a class="collapse-item" href="don-hang-dang-chuan-bi"> <i class="fas fa-spinner mr-1"></i> Đang chuẩn bị</a>
                <a class="collapse-item" href="don-hang-dang-van-chuyen">
                    <i class="fas fa-truck mr-1"></i> Đang vận chuyển
                </a>
                <a class="collapse-item" href="don-hang-hoan-thanh"> <i class="fas fa-check-circle mr-1"></i> Hoàn tất
                </a>
            </div>
        </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
</ul>
<!-- End of Sidebar -->