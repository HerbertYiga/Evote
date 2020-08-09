/*    */ package com.success.handler;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Set;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.authority.AuthorityUtils;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.security.core.userdetails.User;
/*    */ import org.springframework.security.web.DefaultRedirectStrategy;
/*    */ import org.springframework.security.web.RedirectStrategy;
/*    */ import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
/*    */ 
/*    */ public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
/* 21 */   private RedirectStrategy redirectStrategy = (RedirectStrategy)new DefaultRedirectStrategy();
/*    */   
/*    */   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
/* 27 */     HttpSession session = request.getSession();
/* 30 */     User authUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
/* 31 */     session.setAttribute("username", authUser.getUsername());
/* 32 */     session.setAttribute("authorites", authentication.getAuthorities());
/* 35 */     String targetUrl = determineTargetUrl(authentication, request);
/* 36 */     this.redirectStrategy.sendRedirect(request, response, targetUrl);
/*    */   }
/*    */   
/*    */   protected String determineTargetUrl(Authentication authentication, HttpServletRequest request) {
/* 42 */     Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
/* 43 */     if (authorities.contains("ROLE_ADMIN"))
/* 45 */       return "/admin"; 
/* 48 */     if (authorities.contains("ROLE_USER"))
/* 49 */       return "/user"; 
/* 53 */     if (authorities.contains("ROLE_COMMISSIONER"))
/* 55 */       return "/commissionerPanel"; 
/* 60 */     throw new IllegalStateException();
/*    */   }
/*    */   
/*    */   public RedirectStrategy getRedirectStrategy() {
/* 66 */     return this.redirectStrategy;
/*    */   }
/*    */   
/*    */   public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
/* 71 */     this.redirectStrategy = redirectStrategy;
/*    */   }
/*    */ }


/* Location:              C:\Users\ODEL\Downloads\E-vote\WEB-INF\classes\!\com\success\handler\CustomAuthenticationSuccessHandler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */