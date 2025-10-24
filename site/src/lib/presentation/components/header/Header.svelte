<script>
    import HeaderLogo from "$lib/presentation/components/header/HeaderLogo.svelte";
</script>
<header>
    <HeaderLogo></HeaderLogo>
</header>
<style>
    header {
        padding: 0 80px;
        z-index: 1;
        width: 100%;
        position: fixed;
        background-color: #19191c;
    }

    @media (max-width: 767px) {
        header {
            padding: 0;
        }
    }
</style>