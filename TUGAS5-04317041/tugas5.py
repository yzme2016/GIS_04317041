import mapnik
m = mapnik.Map(1080,640)
m.background = mapnik.Color('steelblue')

#################################################################################
s = mapnik.Style()
r = mapnik.Rule()
polygon_symbolizer = mapnik.PolygonSymbolizer()
polygon_symbolizer.fill = mapnik.Color('white')
line_symbolizer = mapnik.LineSymbolizer()
line_symbolizer.stroke = mapnik.Color('green')	
line_symbolizer.stroke_width = 1.0
point_sym = mapnik.PointSymbolizer()
point_sym.allow_overlap = True
r.symbols.append(polygon_symbolizer)
r.symbols.append(line_symbolizer)
r.symbols.append(point_sym)
s.rules.append(r)

#################################################################################
highlight = mapnik.PolygonSymbolizer()
highlight.fill = mapnik.Color('red')
germany = mapnik.Rule()
germany.filter = mapnik.Expression("[NAME]='Germany'")
germany.symbols.append(highlight)
s.rules.append(germany)
m.append_style('stylemap1',s)
#m.append_style('stylemap1',s)
###

#################################################################################
s = mapnik.Style()
r = mapnik.Rule()
polygon_symbolizer = mapnik.PolygonSymbolizer()
polygon_symbolizer.fill = mapnik.Color('purple')
line_symbolizer = mapnik.LineSymbolizer()
#line_symbolizer.stroke = mapnik.Color('yellow')	
#line_symbolizer.stroke_width = 1.0
#point_sym = mapnik.PointSymbolizer()
#point_sym.allow_overlap = True
r.symbols.append(polygon_symbolizer)
#r.symbols.append(point_sym)
r.symbols.append(line_symbolizer)
s.rules.append(r)
m.append_style('stylemap2',s)
#################################################################################
s = mapnik.Style()
r = mapnik.Rule()
polygon_symbolizer = mapnik.PolygonSymbolizer()
polygon_symbolizer.fill = mapnik.Color('magenta')
line_symbolizer = mapnik.LineSymbolizer()
line_symbolizer.stroke = mapnik.Color('black')	
line_symbolizer.stroke_width = 1.0
r.symbols.append(polygon_symbolizer)
r.symbols.append(line_symbolizer)
s.rules.append(r)
m.append_style('stylemap3',s)
#################################################################################
s = mapnik.Style()
r = mapnik.Rule()
polygon_symbolizer = mapnik.PolygonSymbolizer()
polygon_symbolizer.fill = mapnik.Color('blue')
line_symbolizer = mapnik.LineSymbolizer()
line_symbolizer.stroke = mapnik.Color('black')	
line_symbolizer.stroke_width = 1.0
r.symbols.append(polygon_symbolizer)
r.symbols.append(line_symbolizer)
s.rules.append(r)
m.append_style('stylemap4',s)
#################################################################################
s = mapnik.Style()
r = mapnik.Rule()
line_symbolizer = mapnik.LineSymbolizer()
line_symbolizer.stroke = mapnik.Color('red')	
line_symbolizer.stroke_width = 1.0
r.symbols.append(line_symbolizer)
s.rules.append(r)
m.append_style('stylemap5',s)
#################################################################################


sumberdata = mapnik.Shapefile(file="maps/ne_110m_admin_0_countries.shp")
sumberdata2 = mapnik.Shapefile(file="maps/ne_110m_lakes.shp")
sumberdata3 = mapnik.Shapefile(file="maps/ne_110m_geographic_lines")
sumberdata4 = mapnik.Shapefile(file="maps/ne_110m_glaciated_areas.shp")
sumberdata5 = mapnik.Shapefile(file="maps/ne_110m_rivers_lake_centerlines")


lapisan = mapnik.Layer('world')
lapisan.datasource = sumberdata
lapisan2 = mapnik.Layer('lake')
lapisan2.datasource = sumberdata2
lapisan3 = mapnik.Layer('garisdunia')
lapisan3.datasource = sumberdata3
lapisan4 = mapnik.Layer('es')
lapisan4.datasource = sumberdata4
lapisan5 = mapnik.Layer('kali')
lapisan5.datasource = sumberdata5


lapisan.styles.append('stylemap1')
lapisan2.styles.append('stylemap2')
lapisan3.styles.append('stylemap3')
lapisan4.styles.append('stylemap4')
lapisan5.styles.append('stylemap5')

m.layers.append(lapisan)
m.layers.append(lapisan2)
m.layers.append(lapisan3)
m.layers.append(lapisan4)
m.layers.append(lapisan5)

m.zoom_all()
mapnik.render_to_file(m,'tugas5-04317041.pdf', 'pdf')
print "rendered image Success, to file 'tugas5-04317041.pdf'"
