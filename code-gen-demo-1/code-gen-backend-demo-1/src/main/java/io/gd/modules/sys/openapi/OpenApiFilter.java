package io.gd.modules.sys.openapi;


import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;

// https://zhuanlan.zhihu.com/p/140454269
public class OpenApiFilter extends AdviceFilter {

    public OpenApiFilter() {
        System.out.println("openapi过滤器-构造器");
    }

    @Override
    public void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("openapi过滤器-doFilterInternal");
        super.doFilterInternal(request, response, chain);
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("openapi过滤器-preHandle");
        //String data = "123456";
        //response.getOutputStream().write(data.getBytes(),0,6);
        //response.resetBuffer();
        return super.preHandle(request, response);
    }

    @Override
    protected void executeChain(ServletRequest request, ServletResponse response, FilterChain chain) throws Exception {
        System.out.println("openapi过滤器-executeChain");

        WrapperResponse wrapperResponse = new WrapperResponse((HttpServletResponse) response);

        //wrapperResponse.reset();

        //String data = "123456";
        //response.getOutputStream().write(data.getBytes(),1,5);

        //response.getOutputStream().println(123);
        wrapperResponse.flushBuffer();
        //wrapperResponse.getResponse().resetBuffer();

        super.executeChain(request, wrapperResponse, chain);
        //chain.doFilter(request,wrapperResponse);
        System.out.println(wrapperResponse.isCommitted());

        byte[] copy = wrapperResponse.getCopy();
        System.out.println(new String(copy, "utf-8"));// response.getCharacterEncoding()

        //wrapperResponse.getResponse().resetBuffer();
        //wrapperResponse.flushBuffer();

        //wrapperResponse.reset();
        //String data = "123456";
        //wrapperResponse.getOutputStream().println("123456");

        //PrintWriter responseWriter = response.getWriter();
        //responseWriter.flush();


        //wrapperResponse.getOutputStream().close();
        //wrapperResponse.setContentLength(3);
        //wrapperResponse.getOutputStream().println("123");

        /*PrintWriter responseWriter = response.getWriter();

        if (wrapperResponse.getContentType().contains("application/json")){
            CharArrayWriter charWriter = new CharArrayWriter();
            String originalContent = wrapperResponse.toString();
            System.out.println("输出原始数据==="+originalContent);
        }*/
    }

    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("openapi过滤器-postHandle");
        WrapperResponse wrapperResponse = new WrapperResponse((HttpServletResponse) response);
        //wrapperResponse.getResponse().resetBuffer();
        //String data = "123456";
        //wrapperResponse.getOutputStream().write(data.getBytes());

        super.postHandle(request, wrapperResponse);

        byte[] copy = wrapperResponse.getCopy();
        System.out.println(new String(copy, "utf-8"));

    }

    @Override
    public void afterCompletion(ServletRequest request, ServletResponse response, Exception exception) throws Exception {
        System.out.println("openapi过滤器-afterCompletion");
        super.afterCompletion(request, response, exception);
    }

    @Override
    protected void cleanup(ServletRequest request, ServletResponse response, Exception existing) throws ServletException, IOException {
        System.out.println("openapi过滤器-cleanup");
        super.cleanup(request, response, existing);
    }
}

class ServletOutputStreamCopier  extends ServletOutputStream {

    private OutputStream outputStream;
    private ByteArrayOutputStream copy;

    public ServletOutputStreamCopier(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.copy = new ByteArrayOutputStream(1024);
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
        copy.write(b);
    }

    public byte[] getCopy() {
        return copy.toByteArray();
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }
}

class WrapperResponse extends HttpServletResponseWrapper {

    private ServletOutputStream outputStream;
    private PrintWriter writer;
    private ServletOutputStreamCopier copier;
    private HttpServletResponse _response;

    public WrapperResponse(HttpServletResponse response) throws IOException {
        super(response);
        //response.resetBuffer();
        _response = response;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (writer != null) {
            throw new IllegalStateException("getWriter() has already been called on this response.");
        }

        if (outputStream == null) {
            outputStream = getResponse().getOutputStream();
            copier = new ServletOutputStreamCopier(outputStream);
            _response.resetBuffer();
            //outputStream.flush();//TODO:
            //outputStream = new HttpServletOutputStream();
        }

        return copier;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (outputStream != null) {
            throw new IllegalStateException("getOutputStream() has already been called on this response.");
        }

        if (writer == null) {
            copier = new ServletOutputStreamCopier(getResponse().getOutputStream());
            writer = new PrintWriter(new OutputStreamWriter(copier, getResponse().getCharacterEncoding()), true);
            //writer.flush();
        }

        return writer;
    }

    @Override
    public void flushBuffer() throws IOException {
        if (writer != null) {
            writer.flush();
        } else if (outputStream != null) {
            copier.flush();
        }
    }

    public byte[] getCopy() {
        if (copier != null) {
            return copier.getCopy();
        } else {
            return new byte[0];
        }
    }

}
