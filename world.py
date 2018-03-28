import mapnik
m = mapnik.Map(1080,640)
m.background = mapnik.Color('steelblue')
s = mapnik.Style()
r = mapnik.Rule()
polygon_symbolizer = mapnik.PolygonSymbolizer()
polygon_symbolizer.fill = mapnik.Color('white')
r.symbols.append(polygon_symbolizer)

line_symbolizer = mapnik.LineSymbolizer()
line_symbolizer.stroke = mapnik.Color('green')	
line_symbolizer.stroke_width = 2.0

r.symbols.append(line_symbolizer)
s.rules.append(r)
m.append_style('mymap',s)

sumberdata = mapnik.Shapefile(file="ne_110m_admin_0_countries.shp")
lapisan = mapnik.Layer('world')
lapisan.datasource = sumberdata
lapisan.styles.append('mymap')
m.layers.append(lapisan)
m.zoom_all()
mapnik.render_to_file(m,'worldmap.png', 'png')
print "rendered image to 'worldmap.png'"
