<template>
  <div>

  </div>
</template>

<script>
import TopNav from '~/components/TopNav';
import Footer from '~/components/Footer';
export default {
    head:{
        title: '首页',
        link:[
            {rel:'stylesheet',href:"/style/index.css"},
            {rel:'stylesheet',href:"/style/bottomnav.css"},
        ],
        script:[
            {type:"text/javascript",scr:'/js/header.js'},
            {type:"text/javascript",scr:'/js/index.js'},
        ]
    },
    components:{
        TopNav,
        Footer,
    }
}
</script>

<style>

</style>