<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Titres des BD</title>
            </head>
            <body>
                <h1>Titres des BD</h1>
                <ul>
                    <xsl:for-each select="bd">
                        <li>
                            <h2>Titre de la BD : </h2>
                            <xsl:value-of select="./titre"/>
                            <p>Description : </p>
                            <xsl:value-of select="./description"/>
                            <p>Auteur : </p>
                            <xsl:value-of select="./auteur"/>
                            <p>Illustrateur : </p>
                            <xsl:value-of select="./illustrateur"/>
                        </li>
                    </xsl:for-each>
                </ul>
                <footing>
                    <p>Nombre de BD : </p>
                    <xsl:value-of select="count(bd)"/>
                </footing>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>