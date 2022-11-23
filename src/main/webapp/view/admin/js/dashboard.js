document.querySelector('.dropdown-menu-filter').addEventListener('click', async (e) => {
    const filter = document.querySelector('.btn-filter')
    console.log(filter.textContent )
    console.log(e.target.textContent )
    if (filter.textContent !== e.target.textContent) {
        filter.textContent = e.target.textContent;
        const row = document.getElementById("main-data")
        // row.innerHTML = `</div><div class="spinner-border spinner-border-lg text-primary style="align-content: center; align-items: center; left:50%;"  id="spinner"" role="status">
        //                   <span class="visually-hidden">Loading...</span>
        //                 </div>` + row.innerHTML
        const t = {Year: 0, Month: 1, Week: 2, Day: 3};
        let date = document.getElementById("flatpickr-date").value.toString() != "" ? "&date=" + document.getElementById("flatpickr-date").value : "";
        const data = await fetch(`/project_web_programming_war_exploded/admin/getStatitis?option=${t[e.target.textContent]}${date}`);
        const res = await data.json()
        console.log(res)
        // document.getElementById("spinner").remove();


        document.getElementById("newProfit").textContent = res["coutNewProfit"];
        document.getElementById("newShop").textContent = res["coutNewShop"];
        document.getElementById("newUser").textContent = res["coutNewUser"];


        /// Graph
        let dataX = []
        let dataY = []

        dataX = Object.keys(res["prods"])
        dataY = Object.keys(res["prods"]).map((k) => res["prods"][k])

        const analyticsBarChartEl = document.querySelector('#analyticsBarChart'),
            analyticsBarChartConfig = {
                chart: {
                    height: 260,
                    type: 'bar',
                    toolbar: {
                        show: false
                    }
                },
                plotOptions: {
                    bar: {
                        horizontal: false,
                        columnWidth: '20%',
                        borderRadius: 3,
                        startingShape: 'rounded'
                    }
                },
                dataLabels: {
                    enabled: false
                },
                colors: [config.colors.primary, config.colors_label.primary],
                series: [
                    {
                        name: 'data',
                        data: dataY
                    }
                ],
                grid: {
                    borderColor:  config.colors_dark.borderColor
                },
                xaxis: {
                    categories: dataX,
                    axisBorder: {
                        show: false
                    },
                    axisTicks: {
                        show: false
                    },
                    labels: {
                        style: {
                            colors: config.colors.axisColor
                        }
                    }
                },
                yaxis: {
                    min: 0,
                    max: 30,
                    tickAmount: 3,
                    labels: {
                        style: {
                            colors: config.colors.axisColor
                        }
                    }
                },
                legend: {
                    show: false
                },
                tooltip: {
                    y: {
                        formatter: function (val) {
                            return  + val + ' products';
                        }
                    }
                }
            };
        document.querySelector('#analyticsBarChart').innerHTML=""
        if (typeof analyticsBarChartEl !== undefined && analyticsBarChartEl !== null) {
            const analyticsBarChart = new ApexCharts(analyticsBarChartEl, analyticsBarChartConfig);
            analyticsBarChart.render();
        }

        dataX = Object.keys(res["users"])
        dataY = Object.keys(res["users"]).map((k) => res["users"][k])
        document.querySelector('#horizontalBarChartUser').innerHTML=""

        const horizontalBarChartUserEl = document.querySelector('#horizontalBarChartUser'),
            horizontalBarChartUserConfig = {
                chart: {
                    height: 400,
                    fontFamily: 'IBM Plex Sans',
                    type: 'bar',
                    toolbar: {
                        show: false
                    }
                },
                plotOptions: {
                    bar: {
                        horizontal: true,
                        barHeight: '30%',
                        startingShape: 'rounded',
                        borderRadius: 8
                    }
                },
                grid: {
                    borderColor: config.colors.borderColor,
                    xaxis: {
                        lines: {
                            show: false
                        }
                    },
                    padding: {
                        top: -20,
                        bottom: -12
                    }
                },
                colors: config.colors.info,
                dataLabels: {
                    enabled: false
                },
                series: [
                    {
                        data: dataY
                    }
                ],
                xaxis: {
                    categories: dataX,
                    axisBorder: {
                        show: false
                    },
                    axisTicks: {
                        show: false
                    },
                    labels: {
                        style: {
                            colors: config.colors.axisColor,
                            fontSize: '13px'
                        }
                    }
                },
                yaxis: {
                    labels: {
                        style: {
                            colors:config.colors.axisColor,
                            fontSize: '13px'
                        }
                    }
                }
            };
        if (typeof horizontalBarChartUserEl !== undefined && horizontalBarChartUserEl !== null) {
            const horizontalBarChart = new ApexCharts(horizontalBarChartUserEl, horizontalBarChartUserConfig);
            horizontalBarChart.render();
        }

        // new shop
        dataX = Object.keys(res["stores"])
        dataY = Object.keys(res["stores"]).map((k) => res["stores"][k])
        document.querySelector('#horizontalBarChartShop').innerHTML=""
        const horizontalBarChartShopEl = document.querySelector('#horizontalBarChartShop'),
            horizontalBarChartShopConfig = {
                chart: {
                    height: 400,
                    fontFamily: 'IBM Plex Sans',
                    type: 'bar',
                    toolbar: {
                        show: false
                    }
                },
                plotOptions: {
                    bar: {
                        horizontal: true,
                        barHeight: '30%',
                        startingShape: 'rounded',
                        borderRadius: 8
                    }
                },
                grid: {
                    borderColor: config.colors.borderColor,
                    xaxis: {
                        lines: {
                            show: false
                        }
                    },
                    padding: {
                        top: -20,
                        bottom: -12
                    }
                },
                colors: config.colors.info,
                dataLabels: {
                    enabled: false
                },
                series: [
                    {
                        data: dataY
                    }
                ],
                xaxis: {
                    categories: dataX,
                    axisBorder: {
                        show: false
                    },
                    axisTicks: {
                        show: false
                    },
                    labels: {
                        style: {
                            colors: config.colors.axisColor,
                            fontSize: '13px'
                        }
                    }
                },
                yaxis: {
                    labels: {
                        style: {
                            colors: config.colors.axisColor,
                            fontSize: '13px'
                        }
                    }
                }
            };
        if (typeof horizontalBarChartShopEl !== undefined && horizontalBarChartShopEl !== null) {
            const horizontalBarChartShop = new ApexCharts(horizontalBarChartShopEl, horizontalBarChartShopConfig);
            horizontalBarChartShop.render();
        }

        dataX = Object.keys(res["orders"])
        dataY = Object.keys(res["orders"]).map((k) => res["orders"][k])
        document.querySelector('#lineChart').innerHTML=""
        const lineChartEl = document.querySelector('#lineChart'),
            lineChartConfig = {
                chart: {
                    height: 400,
                    fontFamily: 'IBM Plex Sans',
                    type: 'line',
                    parentHeightOffset: 0,
                    zoom: {
                        enabled: false
                    },
                    toolbar: {
                        show: false
                    }
                },
                series: [
                    {
                        data: dataY
                    }
                ],
                markers: {
                    strokeWidth: 7,
                    strokeOpacity: 1,
                    strokeColors: [config.colors.white],
                    colors: [config.colors.warning]
                },
                dataLabels: {
                    enabled: false
                },
                stroke: {
                    curve: 'straight'
                },
                colors: [config.colors.warning],
                grid: {
                    borderColor: config.colors.borderColor,
                    xaxis: {
                        lines: {
                            show: true
                        }
                    },
                    padding: {
                        top: -20
                    }
                },
                tooltip: {
                    custom: function ({ series, seriesIndex, dataPointIndex, w }) {
                        return '<div class="px-3 py-2">' + '<span>' + series[seriesIndex][dataPointIndex] + 'VND</span>' + '</div>';
                    }
                },
                xaxis: {
                    categories: dataX,
                    axisBorder: {
                        show: false
                    },
                    axisTicks: {
                        show: false
                    },
                    labels: {
                        style: {
                            colors: config.colors.axisColor,
                            fontSize: '13px'
                        }
                    }
                },
                yaxis: {
                    labels: {
                        style: {
                            colors: config.colors.axisColor,
                            fontSize: '13px'
                        }
                    }
                }
            };
        if (typeof lineChartEl !== undefined && lineChartEl !== null) {
            const lineChart = new ApexCharts(lineChartEl, lineChartConfig);
            lineChart.render();
        }
    }
});

