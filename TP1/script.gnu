#!/usr/bin/gnuplot
#
# gnuplot 4.6 patchlevel 0

reset

# wxt
set terminal wxt size 1500,1500 enhanced font 'Verdana,10' persist
# png
set terminal pngcairo size 1500,1500 enhanced font 'Verdana,10'
set output ARG1.'.png'

# color definitions
set border linewidth 1.5
set style line 1 lc rgb '#0060ad' pt 7 ps 1.5 lt 1 lw 2 # --- blue

unset key

# Axes
set style line 11 lc rgb '#808080' lt 1
set border 3 back ls 11
set tics nomirror out scale 2
# Grid
set style line 12 lc rgb'#808080' lt 0 lw 1
set grid back ls 12

set tics scale 0.75
set xtics 10000
set ytics 10000
set xrange [0:250000]
set yrange [0:250000]
set xlabel 'x' 
set ylabel 'y'

plot ARG1.'.txt' w p ls 2
