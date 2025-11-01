<script>
    const {headerNavigationOption} = $props()
    import {page} from '$app/state';

    let dividerStyle = $state("divider-style ");
    if (page.url.pathname === headerNavigationOption.endpoint) {
        dividerStyle += "visible"
    } else {
        dividerStyle += "hidden"
    }

    let labelStyle = $state("label-style ");
    if (page.url.pathname === headerNavigationOption.endpoint) {
        labelStyle += "selected"
    } else {
        labelStyle += "unselected"
    }
</script>
<li>
    <a class={labelStyle} href={headerNavigationOption.endpoint}>
        <span>{headerNavigationOption.label}</span>
        <div class={dividerStyle}></div>
    </a>
</li>
<!--suppress CssUnusedSymbol -->
<style>
    li {
        height: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .label-style {
        display: flex;
        padding: 0 20px;
        font-size: 14px;
        align-items: center;
        text-decoration: none;
        flex-direction: column;
    }

    .label-style:hover {
        font-weight: 500;
        color: var(--primary-color);
    }

    .selected {
        font-weight: 600;
        color: var(--primary-color);
    }

    .unselected {
        font-weight: 400;
        color: var(--secondary-font-color);
    }

    .divider-style {
        height: 3px;
        width: 28px;
        margin-top: 8px;
        border-radius: 20px;
    }

    .visible {
        background-color: var(--primary-color);
    }

    .hidden {
        background-color: transparent;
    }
</style>