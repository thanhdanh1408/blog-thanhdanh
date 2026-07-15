/**
 * Personal Blog - Main JavaScript
 * Author: Phan Thanh Danh
 * Version: 1.0.0
 *
 * Handles:
 * - Navbar scroll behavior (shrink & background change)
 * - Active nav link highlighting
 * - Scroll-triggered fade-in animations (Intersection Observer)
 */

document.addEventListener('DOMContentLoaded', function () {

    // ==================== Navbar Scroll Behavior ====================
    const navbar = document.getElementById('mainNavbar');

    if (navbar) {
        window.addEventListener('scroll', function () {
            if (window.scrollY > 50) {
                navbar.classList.add('scrolled');
            } else {
                navbar.classList.remove('scrolled');
            }
        });
    }

    // ==================== Scroll Animations ====================
    const animateElements = document.querySelectorAll('[data-animate]');

    if (animateElements.length > 0) {
        const observer = new IntersectionObserver(
            function (entries) {
                entries.forEach(function (entry) {
                    if (entry.isIntersecting) {
                        entry.target.classList.add('visible');
                        observer.unobserve(entry.target);
                    }
                });
            },
            {
                threshold: 0.1,
                rootMargin: '0px 0px -50px 0px'
            }
        );

        animateElements.forEach(function (el) {
            observer.observe(el);
        });
    }

    // ==================== Smooth Scroll for Anchor Links ====================
    document.querySelectorAll('a[href^="#"]').forEach(function (anchor) {
        anchor.addEventListener('click', function (e) {
            var targetId = this.getAttribute('href');

            if (targetId && targetId !== '#') {
                var targetElement = document.querySelector(targetId);

                if (targetElement) {
                    e.preventDefault();
                    targetElement.scrollIntoView({
                        behavior: 'smooth',
                        block: 'start'
                    });
                }
            }
        });
    });

    // ==================== Close Mobile Nav on Link Click ====================
    var navLinks = document.querySelectorAll('.navbar-nav .nav-link');
    var navCollapse = document.getElementById('navbarNav');

    if (navCollapse) {
        navLinks.forEach(function (link) {
            link.addEventListener('click', function () {
                var bsCollapse = bootstrap.Collapse.getInstance(navCollapse);
                if (bsCollapse) {
                    bsCollapse.hide();
                }
            });
        });
    }

});
