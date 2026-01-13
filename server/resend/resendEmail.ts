import { generatePasswordResetEmailHtml, generateResetSuccessEmailHtml, generateWelcomeEmailHtml, htmlContent } from "./htmlEmail";
import { resend, sender } from "./resend";

export const sendVerificationEmailResend = async (email: string, verificationToken: string) => {
    try {
        console.log(`📧 Attempting to send verification email to: ${email}`);
        console.log(`🔑 Verification code: ${verificationToken}`);
        
        // Send real email via Resend
        const result = await resend.emails.send({
            from: `${sender.name} <${sender.email}>`,
            to: email,
            subject: 'Verify your email - Food Hub',
            html: htmlContent.replace("{verificationToken}", verificationToken),
        });
        
        console.log(`✅ Verification email sent successfully:`, result);
        return result;
    } catch (error) {
        console.log("❌ Resend verification email error:", error);
        throw new Error("Failed to send email verification");
    }
}

export const sendWelcomeEmailResend = async (email: string, name: string) => {
    try {
        const htmlContentEmail = generateWelcomeEmailHtml(name);
        const result = await resend.emails.send({
            from: `${sender.name} <${sender.email}>`,
            to: email,
            subject: 'Welcome to Food Hub',
            html: htmlContentEmail,
        });
        return result;
    } catch (error) {
        console.log("Resend welcome email error:", error);
        throw new Error("Failed to send welcome email");
    }
}

export const sendPasswordResetEmailResend = async (email: string, resetURL: string) => {
    try {
        const htmlContentEmail = generatePasswordResetEmailHtml(resetURL);
        const result = await resend.emails.send({
            from: `${sender.name} <${sender.email}>`,
            to: email,
            subject: 'Reset your password',
            html: htmlContentEmail,
        });
        return result;
    } catch (error) {
        console.log("Resend password reset email error:", error);
        throw new Error("Failed to send password reset email");
    }
}

export const sendResetSuccessEmailResend = async (email: string) => {
    try {
        const htmlContentEmail = generateResetSuccessEmailHtml();
        const result = await resend.emails.send({
            from: `${sender.name} <${sender.email}>`,
            to: email,
            subject: 'Password Reset Successfully',
            html: htmlContentEmail,
        });
        return result;
    } catch (error) {
        console.log("Resend reset success email error:", error);
        throw new Error("Failed to send password reset success email");
    }
}
