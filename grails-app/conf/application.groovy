
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.tucanoo.mep.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.tucanoo.mep.UserRole'
grails.plugin.springsecurity.authority.className = 'com.tucanoo.mep.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]
//        securityRequestHolderFilter,channelProcessingFilter,statelessSecurityContextPersistenceFilter,logoutFilter,authenticationProcessingFilter,customBasicAuthenticationFilter,securityContextHolderAwareRequestFilter,basicExceptionTranslationFilter,filterInvocationInterceptor'
def JOINED = 'securityContextPersistenceFilter,logoutFilter,capuletsAuthenticationFilter,montaguesAuthenticationFilter,' +
           'authenticationProcessingFilter,rememberMeAuthenticationFilter,anonymousAuthenticationFilter,' +
           'exceptionTranslationFilter,filterInvocationInterceptor'

//grails.plugin.springsecurity.filterChain.filterNames = [
//   'securityContextPersistenceFilter', 'logoutFilter',
//   'capuletsAuthenticationFilter','montaguesAuthenticationFilter', 'authenticationProcessingFilter',
//   'rememberMeAuthenticationFilter', 'anonymousAuthenticationFilter',
//   'exceptionTranslationFilter', 'filterInvocationInterceptor'
//]
grails.plugin.springsecurity.filterChain.filterNames = [
   'securityContextPersistenceFilter', 'logoutFilter',
   'authenticationProcessingFilter',
   'rememberMeAuthenticationFilter', 'anonymousAuthenticationFilter',
   'exceptionTranslationFilter', 'filterInvocationInterceptor'
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
//	[pattern: '/capulets/**',    filters: 'JOINED_FILTERS,-montaguesAuthenticationFilter'],
//	[pattern: '/montagues/**',   filters: 'JOINED_FILTERS,-capuletsAuthenticationFilter'],
//  [pattern: '/capulets/**',    filters: 'capuletsAuthenticationFilter'],
//	[pattern: '/montagues/**',   filters: 'montaguesAuthenticationFilter'],

  [pattern: '/capulets/**',    filters: 'securityContextPersistenceFilter,logoutFilter,capuletsAuthenticationFilter,' +
           'authenticationProcessingFilter,rememberMeAuthenticationFilter,anonymousAuthenticationFilter,' +
           'exceptionTranslationFilter,filterInvocationInterceptor'],

  [pattern: '/montagues/**',   filters: 'securityContextPersistenceFilter,logoutFilter,montaguesAuthenticationFilter,' +
           'authenticationProcessingFilter,rememberMeAuthenticationFilter,anonymousAuthenticationFilter,' +
           'exceptionTranslationFilter,filterInvocationInterceptor'],

	[pattern: '/**',             filters: 'JOINED_FILTERS,-montaguesAuthenticationFilter,-capuletsAuthenticationFilter']
]

grails.plugin.springsecurity.debug.useFilter = true
grails.plugin.springsecurity.providerNames = ['capuletsAuthenticationProvider', 'montaguesAuthenticationProvider', 'anonymousAuthenticationProvider']
