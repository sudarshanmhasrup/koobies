<script>
    import HeaderLogo from "$lib/presentation/components/header/HeaderLogo.svelte";
    import HeaderNavigationOptions from "$lib/presentation/components/header/HeaderNavigationOptions.svelte";
</script>
<header>
    <HeaderLogo></HeaderLogo>
    <HeaderNavigationOptions></HeaderNavigationOptions>
</header>
<style>
    header {
        z-index: 1;
        width: 100%;
        display: flex;
        position: fixed;
        padding: 0 200px;
        align-items: center;
        justify-content: space-between;
    }

    @media (max-width: 767px) {
        header {
            padding: 0;
        }
    }
</style>