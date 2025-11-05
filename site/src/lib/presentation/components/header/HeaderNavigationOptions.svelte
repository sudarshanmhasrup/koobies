<script>
    import headerNavigationOptionsList from "$lib/data/HeaderNavigationOptionsList.js";
    import HeaderNavigationOption from "$lib/presentation/components/header/HeaderNavigationOption.svelte";
</script>
<nav>
    <ul>
        {#each headerNavigationOptionsList as headerNavigationOption}
            <HeaderNavigationOption headerNavigationOption={headerNavigationOption}></HeaderNavigationOption>
        {/each}
    </ul>
</nav>
<style>
    nav {
        height: 100%;
    }

    ul {
        height: 100%;
        display: flex;
    }

    @media screen and (max-width: 1200px) {
        nav {
            display: none;
        }
    }
</style>