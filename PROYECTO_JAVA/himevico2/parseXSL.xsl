<?xml version="1.0" encoding="ISO-8859-1"?>
	<xsl:stylesheet xmlns:xs="http://www.w3.org/1999/XSL/Transform" version="1.0">
		<xsl:template mathc="/">
			<html>
				<head>
					<author>Iker y Miguel - Equipo 1 </author>
					<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
						<title>XSL Para el Parse de los Partes</title>
							<style type="text/css">
							table {
								font-family: Verdana, Geneva, sans-serif;
								font-size: 12px;
								font-weight: bold;
								background-color: #3FF;
							}
							</style>
				</head>
				<body>
					<div align="center">
					<h2>ListaPartes</h2>
						<table border="1">
							<tr>
								<th>idParte</th>
								<th>fecha</th>
								<th>kmInicio</th>
								<th>kmFinal</th>
								<th>finalizado</th>
								<th>gasoil</th>
								<th>autopista</th>
								<th>dietas</th>
								<th>otrosGastos</th>
								<th>incidencias</th>
								<th>horasTRabajadas</th>
							</tr>
							<xsl:for-each select="listaPartes/parte">
								<tr>
									<td>
									  <xsl:value-of select="field[@name='idParte" />
									</td>
									<td>
									  <xsl:value-of select="field[@name = 'fecha']" />
									</td>
									<td>
									  <xsl:value-of select="field[@name='kmInicio']" />
									</td>
									<td>
									  <xsl:value-of select="field[@name='kmFinal']" />
									</td>
									<td>
									  <xsl:value-of select="field[@name='finalizado']" />
									</td>
									<td>
									  <xsl:value-of select="field[@name='gasoil']" />
									</td>
									<td>
									  <xsl:value-of select="field[@name='autopista']" />
									</td>
									<td>
									  <xsl:value-of select="field[@name='dietas']" />
									</td>
									<td>
									  <xsl:value-of select="field[@name='otrosGastos']" />
									</td>
									<td>
									  <xsl:value-of select="field[@name='incidencias']" />
									</td>
									<td>
									  <xsl:value-of select="field[@name='horasTRabajadas']" />
									</td>
								</tr>
							</xsl:for-each>
						</table>
					</div>
				</body>
			</html>
		</xsl:template>
	</xsl:stylesheet>