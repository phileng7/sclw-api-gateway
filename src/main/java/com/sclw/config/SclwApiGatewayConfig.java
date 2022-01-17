package com.sclw.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sclw.filter.JwtAuthenticationFilter;

@Configuration
public class SclwApiGatewayConfig {
	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("login", r -> r.path("/login/**").filters(f -> f.filter(filter)).uri("lb://sclw-auth"))
				.route("greetings", r -> r.path("/").uri("lb://sclw-auth"))
				.route("LaudosCreate", r -> r.path("/laudos").filters(f -> f.filter(filter)).uri("lb://sclw-create"))
				.route("LaudosMedAsntConc", r -> r.path("/laudos/medasntconc/**").filters(f -> f.filter(filter)).uri("lb://sclw-create"))
				.route("LaudosMedAsntDtConc", r -> r.path("/laudos/medasntdtconc/**").filters(f -> f.filter(filter)).uri("lb://sclw-create"))
				.route("LaudosMedAsntDtRConc", r -> r.path("/laudos/medasntdtrconc/**").filters(f -> f.filter(filter)).uri("lb://sclw-create"))
				.route("MedAsnt", r -> r.path("/medasnts/**").filters(f -> f.filter(filter)).uri("lb://sclw-create"))
				.route("Pacientes", r -> r.path("/pacientes/**").filters(f -> f.filter(filter)).uri("lb://sclw-create"))
				.route("TipoExames", r -> r.path("/tipoexames/**").filters(f -> f.filter(filter)).uri("lb://sclw-create"))
				.route("Temas", r -> r.path("/temas/**").filters(f -> f.filter(filter)).uri("lb://sclw-create"))
				.route("Procedimentos", r -> r.path("/procedimentos/**").filters(f -> f.filter(filter)).uri("lb://sclw-create"))
				.route("Frases", r -> r.path("/frases/**").filters(f -> f.filter(filter)).uri("lb://sclw-create"))
				.route("AuxTipoExames", r -> r.path("/auxtipoexames/**").filters(f -> f.filter(filter)).uri("lb://sclw-laudo-edit"))
				.route("AuxProcedimentos", r -> r.path("/auxprocedimentos/**").filters(f -> f.filter(filter)).uri("lb://sclw-laudo-edit"))
				.route("LaudosAux", r -> r.path("/laudos/aux/**").filters(f -> f.filter(filter)).uri("lb://sclw-laudo-edit"))
				.route("LaudosMain", r -> r.path("/laudos/main/**").filters(f -> f.filter(filter)).uri("lb://sclw-laudo-edit"))
				.route("AuxTemas", r -> r.path("/auxtemas/**").filters(f -> f.filter(filter)).uri("lb://sclw-laudo-edit"))
				.route("AuxFrases", r -> r.path("/auxfrases/**").filters(f -> f.filter(filter)).uri("lb://sclw-laudo-edit"))	
				.route("Conclusao", r -> r.path("/laudos/conc/**").filters(f -> f.filter(filter)).uri("lb://sclw-laudo-edit"))
				.route("Medicoes", r -> r.path("/medicoes/**").filters(f -> f.filter(filter)).uri("lb://sclw-laudo-edit"))
				.route("Fotos", r -> r.path("/fotos/**").filters(f -> f.filter(filter)).uri("lb://sclw-laudo-edit"))
				.route("Comentario", r -> r.path("/laudo_comentario/**").filters(f -> f.filter(filter)).uri("lb://sclw-laudo-edit"))				
				.route("LaudosMedAsnt", r -> r.path("/laudos/medasnt/**").filters(f -> f.filter(filter)).uri("lb://sclw-report"))
				.route("LaudosId", r -> r.path("/laudos/id/**").filters(f -> f.filter(filter)).uri("lb://sclw-report"))
				.route("hello", r -> r.path("/hello/**").filters(f -> f.filter(filter)).uri("lb://hello"))
				.build();
	}

}
